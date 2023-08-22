package org.pahappa.systems.invoicemis.core.services;

import org.pahappa.systems.invoicemis.models.settings.ApplicationSettings;

/**
 * Responsible for CRUD operations on {@link ApplicationSettings}
 */
public interface ApplicationSettingsService extends GenericService<ApplicationSettings> {
    /**
     * Gets {@link ApplicationSettings}
     *
     * @return
     */
    ApplicationSettings getActiveApplicationSettings();
}
