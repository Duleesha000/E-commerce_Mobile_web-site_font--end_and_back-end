package com.devtechnexus.delivery.model;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * small data class to help handle graphhopper data
 * <h3>Fields</h3>
 * <li>double lat - latitude</li>
 * <li>double lon - longitude</li>
 *
 * This is used by graphhopper as it does not accept string addresses straight away for their ROUTING API.
 */
@Data
@AllArgsConstructor
public class GeoPoint {
    private double lat;
    private double lon;
}
