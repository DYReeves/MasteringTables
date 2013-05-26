/**
 * Get more info at : www.jrebirth.org .
 * Copyright JRebirth.org © 2011-2013
 * Contact : sebastien.bordes@jrebirth.org
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.jrebirth.demo.masteringtables.ui.start;

import java.util.List;

import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.demo.masteringtables.beans.Expression;
import org.jrebirth.demo.masteringtables.beans.GameSettings;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;
import org.jrebirth.demo.masteringtables.ui.MTWaves;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class StartModel.
 */
public class StartModel extends AbstractModel<StartModel, StartView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(StartModel.class);

    private ExpressionBuilderService expressionBuilderService;

    /** The game settings. */
    private final GameSettings gameSettings = new GameSettings();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitialize() {

        listen(ExpressionBuilderService.RE_TABLES_BUILT);
        listen(MTWaves.REGISTER_FAILURE);

        // Store an hard link to avoid garbage collection of the service
        expressionBuilderService = getService(ExpressionBuilderService.class);

        returnData(ExpressionBuilderService.class, ExpressionBuilderService.DO_BUILD_TABLES);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitializeInnerModels() {
        // Put the code to initialize inner models here (if any)
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void processAction(final Wave wave) {
        // Process a wave action, you must listen the wave type before
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customShowView() {
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customHideView() {
        // Custom code to process when the view is hidden
    }

    /**
     * Tables built.
     * 
     * @param allTables the all tables
     * @param wave the wave
     */
    public void tablesBuilt(final List<Expression> allTables, final Wave wave) {

    }

    /**
     * Gets the game settings.
     * 
     * @return the game settings
     */
    public GameSettings getGameSettings() {
        return this.gameSettings;
    }
}
