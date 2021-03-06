/*
 * Copyright 2010, 2011, 2012 mapsforge.org
 *
 * This program is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package org.mapsforge.map.rendertheme.renderinstruction;

import org.junit.Assert;

import org.junit.Test;
import org.mapsforge.map.rendertheme.GraphicAdapter;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.AttributesImpl;

public class CircleBuilderTest {
	private static final int LEVEL = 2;
	private static final float RADIUS = 3.3f;
	private static final boolean SCALE_RADIUS = true;
	private static final float STROKE_WIDTH = 4.4f;

	@Test
	public void buildTest() throws SAXException {
		GraphicAdapter graphicAdapter = new DummyGraphicAdapter();
		AttributesImpl attributesImpl = new AttributesImpl();
		attributesImpl.addAttribute(null, null, CircleBuilder.RADIUS, null, String.valueOf(RADIUS));
		attributesImpl.addAttribute(null, null, CircleBuilder.SCALE_RADIUS, null, String.valueOf(SCALE_RADIUS));
		attributesImpl.addAttribute(null, null, CircleBuilder.STROKE_WIDTH, null, String.valueOf(STROKE_WIDTH));

		CircleBuilder circleBuilder = new CircleBuilder(graphicAdapter, "circle", attributesImpl, LEVEL);

		Assert.assertEquals(LEVEL, circleBuilder.level);
		Assert.assertEquals(RADIUS, circleBuilder.radius.floatValue(), 0);
		Assert.assertEquals(SCALE_RADIUS, circleBuilder.scaleRadius);
		Assert.assertEquals(STROKE_WIDTH, circleBuilder.strokeWidth, 0);
		Assert.assertNotNull(circleBuilder.build());
	}
}
