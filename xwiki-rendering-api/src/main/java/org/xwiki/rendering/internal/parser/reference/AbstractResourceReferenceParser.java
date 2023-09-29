/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.rendering.internal.parser.reference;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Provider;

import org.xwiki.component.manager.ComponentManager;
import org.xwiki.rendering.parser.ResourceReferenceParser;
import org.xwiki.rendering.wiki.WikiModel;

/**
 * Common methods for resource parser for links and images.
 *
 * @version $Id$
 * @since 4.5M1
 */
public abstract class AbstractResourceReferenceParser implements ResourceReferenceParser
{
    @Inject
    @Named("context")
    protected Provider<ComponentManager> componentManagerProvider;

    /**
     * Used to verify if we're in wiki mode or not by looking up an implementation of
     * {@link org.xwiki.rendering.wiki.WikiModel}.
     */
    @Inject
    protected Provider<WikiModel> wikiModelProvider;

    /**
     * @return true if we're in wiki mode (i.e. an implementing class for {@link org.xwiki.rendering.wiki.WikiModel}
     *         exists)
     */
    protected boolean isInWikiMode()
    {
        return this.wikiModelProvider.get() != null;
    }
}
