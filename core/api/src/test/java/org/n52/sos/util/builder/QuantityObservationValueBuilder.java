/*
 * Copyright (C) 2012-2021 52°North Spatial Information Research GmbH
 *
 * This program is free software; you can redistribute it and/or modify it
 * under the terms of the GNU General Public License version 2 as published
 * by the Free Software Foundation.
 *
 * If the program is linked with libraries which are licensed under one of
 * the following licenses, the combination of the program with the linked
 * library is not considered a "derivative work" of the program:
 *
 *     - Apache License, version 2.0
 *     - Apache Software License, version 1.0
 *     - GNU Lesser General Public License, version 3
 *     - Mozilla Public License, versions 1.0, 1.1 and 2.0
 *     - Common Development and Distribution License (CDDL), version 1.0
 *
 * Therefore the distribution of the program linked with libraries licensed
 * under the aforementioned licenses, is permitted by the copyright holders
 * if the distribution is compliant with both the GNU General Public
 * License version 2 and the aforementioned licenses.
 *
 * This program is distributed in the hope that it will be useful, but
 * WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU General
 * Public License for more details.
 */
package org.n52.sos.util.builder;

import java.math.BigDecimal;

import org.joda.time.DateTime;

import org.n52.shetland.ogc.gml.time.TimeInstant;
import org.n52.shetland.ogc.om.SingleObservationValue;
import org.n52.shetland.ogc.om.values.QuantityValue;
import org.n52.shetland.ogc.om.values.Value;

/**
 * @author <a href="mailto:e.h.juerrens@52north.org">Eike Hinderk
 *         J&uuml;rrens</a>
 * @since 4.0.0
 */
public class QuantityObservationValueBuilder {

    private Value<BigDecimal> quantity;

    private long phenomenonTime;

    public static QuantityObservationValueBuilder aQuantityValue() {
        return new QuantityObservationValueBuilder();
    }

    public QuantityObservationValueBuilder setValue(QuantityValue quantity) {
        this.quantity = quantity;
        return this;
    }

    public QuantityObservationValueBuilder setPhenomenonTime(long currentTimeMillis) {
        this.phenomenonTime = currentTimeMillis;
        return this;
    }

    public SingleObservationValue<BigDecimal> build() {
        SingleObservationValue<BigDecimal> value = new SingleObservationValue<BigDecimal>();
        value.setValue(quantity);
        value.setPhenomenonTime(new TimeInstant(new DateTime(phenomenonTime)));
        return value;
    }

}
