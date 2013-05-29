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
package org.jrebirth.demo.masteringtables.ui.menu;

import org.jrebirth.core.ui.AbstractModel;
import org.jrebirth.core.wave.Wave;
import org.jrebirth.demo.masteringtables.beans.GameSettings;
import org.jrebirth.demo.masteringtables.service.ExpressionBuilderService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * The Class GameMenuModel.
 */
public class GameMenuModel extends AbstractModel<GameMenuModel, GameMenuView> {

    /** The Constant LOGGER. */
    private static final Logger LOGGER = LoggerFactory.getLogger(GameMenuModel.class);

    private ExpressionBuilderService expressionBuilderService;

    /** The game settings bean. */
    private final GameSettings gameSettings = new GameSettings();

    /**
     * {@inheritDoc}
     */
    @Override
    protected void customInitialize() {

        // Be notified when tables are ready
        listen(ExpressionBuilderService.RE_TABLES_BUILT);

        // Store an hard link to avoid garbage collection of the service
        this.expressionBuilderService = getService(ExpressionBuilderService.class);

        // Generate all tables
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
        // Custom code to process when the view is shown
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
    public void tablesBuilt(final Wave wave) {

        final int nbExpression = this.expressionBuilderService.getAdditionTable().size()
                + this.expressionBuilderService.getDivisionTable().size()
                + this.expressionBuilderService.getSubtractionTable().size()
                + this.expressionBuilderService.getMultiplicationTable().size();

        LOGGER.info("Tables are available and contains {} expressions.", nbExpression);
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