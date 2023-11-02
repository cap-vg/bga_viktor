package com.capgemini.bga.boardgamesapp.dataaccess.api.repo;

import static com.querydsl.core.alias.Alias.$;

import java.math.BigDecimal;
import java.util.Iterator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;

import com.capgemini.bga.boardgamesapp.dataaccess.api.GamePlayEntity;
import com.capgemini.bga.boardgamesapp.logic.api.to.GamePlaySearchCriteriaTo;
import com.devonfw.module.jpa.dataaccess.api.QueryUtil;
import com.devonfw.module.jpa.dataaccess.api.data.DefaultRepository;
import com.querydsl.jpa.impl.JPAQuery;

/**
 * {@link DefaultRepository} for {@link GamePlayEntity}
 */
public interface GamePlayRepository extends DefaultRepository<GamePlayEntity> {

    /**
     * @param criteria the {@link GamePlaySearchCriteriaTo} with the criteria to search.
     * @return the {@link Page} of the {@link GamePlayEntity} objects that matched the search. If no pageable is set, it
     * will return a unique page with all the objects that matched the search.
     */
    default Page<GamePlayEntity> findByCriteria(GamePlaySearchCriteriaTo criteria) {

        GamePlayEntity alias = newDslAlias();
        JPAQuery<GamePlayEntity> query = newDslQuery(alias);

        Long game = criteria.getGameId();
        if (game != null) {
            query.where($(alias.getGame().getId()).eq(game));
        }
        BigDecimal duration = criteria.getDuration();
        if (duration != null) {
            query.where($(alias.getDuration()).eq(duration));
        }
        if (criteria.getPageable() == null) {
            criteria.setPageable(PageRequest.of(0, Integer.MAX_VALUE));
        } else {
            addOrderBy(query, alias, criteria.getPageable().getSort());
        }

        return QueryUtil.get().findPaginated(criteria.getPageable(), query, true);
    }

    /**
     * Add sorting to the given query on the given alias
     *
     * @param query to add sorting to
     * @param alias to retrieve columns from for sorting
     * @param sort  specification of sorting
     */
    public default void addOrderBy(JPAQuery<GamePlayEntity> query, GamePlayEntity alias, Sort sort) {

        if (sort != null && sort.isSorted()) {
            Iterator<Order> it = sort.iterator();
            while (it.hasNext()) {
                Order next = it.next();
                switch (next.getProperty()) {
                    case "game":
                        if (next.isAscending()) {
                            query.orderBy($(alias.getGame().getId().toString()).asc());
                        } else {
                            query.orderBy($(alias.getGame().getId().toString()).desc());
                        }
                        break;
                    case "duration":
                        if (next.isAscending()) {
                            query.orderBy($(alias.getDuration()).asc());
                        } else {
                            query.orderBy($(alias.getDuration()).desc());
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Sorted by the unknown property '" + next.getProperty() + "'");
                }
            }
        }
    }

}