package com.dog.arquitetura.spring;


import com.dog.arquitetura.lang.annotation.NonNull;
import lombok.experimental.UtilityClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import java.util.List;

@UtilityClass
public class PageableList {

    @NonNull
    public <E> Page<E> of(@Nullable List<E> list, Pageable pageable) {
        if (list == null || list.isEmpty()) return Page.empty(pageable);
        if (pageable.isUnpaged()) return new PageImpl<>(list, pageable, list.size());
        List<E> fragment = list.stream()
                .skip(pageable.getOffset())
                .limit(pageable.getPageSize())
                .toList();
        return new PageImpl<>(fragment, pageable, list.size());
    }

}
