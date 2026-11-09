package it.nexoapp.ntf.config;

import io.quarkus.runtime.annotations.StaticInitSafe;
import io.smallrye.config.ConfigMapping;
import io.smallrye.config.WithDefault;

/**
 * Notification microservice settings, mapped from configuration properties with the {@code ntf} prefix.
 * <p>
 * Every property is optional and falls back to a default when not set.
 */
@StaticInitSafe
@ConfigMapping(prefix = "ntf")
public interface NotificationConfig {

    /**
     * Messaging settings (properties with the {@code ntf.messaging} prefix).
     */
    Messaging messaging();

    // -----------------------------------------------------------------------------------------------------------------

    /**
     * Settings of the event messaging, mapped from the {@code ntf.messaging} prefix.
     */
    interface Messaging {

        /**
         * Name of the topic exchange the outbox relay publishes this service's events on
         * (property {@code ntf.messaging.exchange}). Optional, defaults to {@code nexo.ntf}.
         */
        @WithDefault("nexo.ntf")
        String exchange();

    }

}
