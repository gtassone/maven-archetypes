package ${topPackage}.${subPackage}.${artifactId}.core.service.querydsl;

import com.mysema.query.Query;
import com.mysema.query.types.Order;
import com.mysema.query.types.OrderSpecifier;
import com.mysema.query.types.Path;
import com.mysema.query.types.expr.BooleanExpression;
import com.mysema.query.types.expr.SimpleExpression;
import com.mysema.query.types.path.StringPath;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SortDirectionEnum;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SortOrder;
import ${topPackage}.${subPackage}.${artifactId}.core.service.search.SortOrderList;

public class QueryDslDaoUtils
{

    public static void configureLimits(Query<?> query, long offset, long maxItems) {
        if (offset > 0) {
            query.offset(offset);
        }
        else {
            query.offset(0L);
        }

        if (maxItems > 0) {
            query.limit(maxItems);
        }
        else {
        }
    }

    public static void configureOrderBy(Query<?> query, Path<?> entry, SortOrderList sortOrderList) {
        if ((sortOrderList != null) && (sortOrderList.size() > 0)) {
            List<OrderSpecifier<?>> specifiers = new ArrayList<>();
            for (SortOrder sortOrder : sortOrderList) {
                Order order = Order.ASC;
                if (sortOrder.getSortDirection() == SortDirectionEnum.DESC) {
                    order = Order.DESC;
                }
                StringPath property = new StringPath(entry, sortOrder.getSortField());
                specifiers.add(new OrderSpecifier<>(order, property));
            }
            query.orderBy(specifiers.toArray(new OrderSpecifier[specifiers.size()]));
        }
    }

    public static <T> BooleanExpression buildInExpression(SimpleExpression<T> property, Collection<T> collection) {
        if (CollectionUtils.isEmpty(collection)){
            return property.in(new ArrayList<T>());
        }

        BooleanExpression exp = null;
        final List<T> values = new ArrayList<>(collection);
        final int parameterLimit = 999;
        final int listSize = values.size();
        for (int i = 0; i < listSize; i += parameterLimit) {
            List<T> subList;
            if (listSize > i + parameterLimit)
            {
                subList = values.subList(i, (i + parameterLimit));
            }
            else
            {
                subList = values.subList(i, listSize);
            }

            if (exp != null)
            {
                exp = exp.or(property.in(subList));
            }
            else
            {
                exp = property.in(subList);
            }
        }

        return exp;
    }
}
