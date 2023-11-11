package com.baserent;

import io.micronaut.context.event.StartupEvent;
import io.micronaut.inject.qualifiers.Qualifiers;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.inject.Singleton;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.conf.RenderNameCase;
import org.jooq.conf.RenderQuotedNames;
import org.jooq.conf.Settings;
import org.jooq.impl.DSL;
import org.slf4j.LoggerFactory;

import javax.sql.DataSource;

@Singleton
public class Bootstrap {
    @Inject
    DSLContext context;
    @EventListener
    void init(StartupEvent event) {
        context.settings().setRenderNameCase(RenderNameCase.LOWER);
    }
}
