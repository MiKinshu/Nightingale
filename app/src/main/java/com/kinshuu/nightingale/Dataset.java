package com.example.acer.securityapp;

import android.location.Location;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonStringData {


    public JSONObject getJsonObject() throws JSONException {
        return new JSONObject(jsonString);
    }

    public int checkThreatLevelDanger(JSONObject jsonObject,Location location) throws JSONException {
        JSONArray jsonArray = jsonObject.getJSONArray("data");
        JSONObject locationCluster;
        double latitude,longitude,currLatitude = Math.round(location.getLatitude() * 100.0) / 100.0,currLongitude = Math.round(location.getLongitude() * 100.0) / 100.0;
        for (int i = 0; i < jsonArray.length(); i++) {
            locationCluster = jsonArray.getJSONObject(i);
            longitude = Math.round(locationCluster.getDouble("lati") * 100.0) / 100.0;
            latitude = Math.round(locationCluster.getDouble("longi") * 100.0) / 100.0;
            Log.d("Location Update","reading location"+latitude+" "+longitude);
            if(latitude == currLatitude && longitude == currLongitude){
                return locationCluster.getJSONObject("properties").getInt("mag");
            }
        }
        return 0;
    }
    public static final String jsonString = "{\"data\": [{\n" +
            "\"lati\": 77.249200000000002,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.536300000000001\n" +
            "}, {\n" +
            "\"lati\": 77.085999999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.6127\n" +
            "}, {\n" +
            "\"lati\": 77.2042,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.529900000000001\n" +
            "}, {\n" +
            "\"lati\": 77.236099999999993,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.643599999999999\n" +
            "}, {\n" +
            "\"lati\": 77.193700000000007,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.7026\n" +
            "}, {\n" +
            "\"lati\": 77.293700000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.653400000000001\n" +
            "}, {\n" +
            "\"lati\": 77.226200000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.666399999999999\n" +
            "}, {\n" +
            "\"lati\": 77.265299999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.5307\n" +
            "}, {\n" +
            "\"lati\": 77.066199999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.609100000000002\n" +
            "}, {\n" +
            "\"lati\": 77.267600000000002,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.5623\n" +
            "}, {\n" +
            "\"lati\": 77.306200000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.523\n" +
            "}, {\n" +
            "\"lati\": 77.224199999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.7072\n" +
            "}, {\n" +
            "\"lati\": 77.003600000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.7258\n" +
            "}, {\n" +
            "\"lati\": 77.1738,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.66\n" +
            "}, {\n" +
            "\"lati\": 77.086399999999998,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.5914\n" +
            "}, {\n" +
            "\"lati\": 77.127600000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.7179\n" +
            "}, {\n" +
            "\"lati\": 77.179000000000002,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.570499999999999\n" +
            "}, {\n" +
            "\"lati\": 77.115899999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.702400000000001\n" +
            "}, {\n" +
            "\"lati\": 77.132800000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.674399999999999\n" +
            "}, {\n" +
            "\"lati\": 77.015600000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.6037\n" +
            "}, {\n" +
            "\"lati\": 77.197400000000002,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.736599999999999\n" +
            "}, {\n" +
            "\"lati\": 77.233599999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.652799999999999\n" +
            "}, {\n" +
            "\"lati\": 77.175299999999993,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.709800000000001\n" +
            "}, {\n" +
            "\"lati\": 77.196100000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.603400000000001\n" +
            "}, {\n" +
            "\"lati\": 77.302599999999998,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 3\n" +
            "},\n" +
            "\"longi\": 28.6204\n" +
            "}, {\n" +
            "\"lati\": 77.088800000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.679600000000001\n" +
            "}, {\n" +
            "\"lati\": 77.1511,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.465499999999999\n" +
            "}, {\n" +
            "\"lati\": 77.217500000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.649799999999999\n" +
            "}, {\n" +
            "\"lati\": 77.119900000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.639700000000001\n" +
            "}, {\n" +
            "\"lati\": 77.174899999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.733599999999999\n" +
            "}, {\n" +
            "\"lati\": 77.226200000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.643000000000001\n" +
            "}, {\n" +
            "\"lati\": 77.224999999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.6309\n" +
            "}, {\n" +
            "\"lati\": 77.204899999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.569299999999998\n" +
            "}, {\n" +
            "\"lati\": 77.208600000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.700199999999999\n" +
            "}, {\n" +
            "\"lati\": 77.292199999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.668800000000001\n" +
            "}, {\n" +
            "\"lati\": 77.257400000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.533200000000001\n" +
            "}, {\n" +
            "\"lati\": 77.256399999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.5473\n" +
            "}, {\n" +
            "\"lati\": 77.180499999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.6478\n" +
            "}, {\n" +
            "\"lati\": 77.240499999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.587399999999999\n" +
            "}, {\n" +
            "\"lati\": 77.144999999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.630800000000001\n" +
            "}, {\n" +
            "\"lati\": 77.274600000000007,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.526800000000001\n" +
            "}, {\n" +
            "\"lati\": 77.142200000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.725200000000001\n" +
            "}, {\n" +
            "\"lati\": 76.915599999999998,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.595700000000001\n" +
            "}, {\n" +
            "\"lati\": 77.120800000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.6266\n" +
            "}, {\n" +
            "\"lati\": 77.0608,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.709599999999998\n" +
            "}, {\n" +
            "\"lati\": 77.101900000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.710000000000001\n" +
            "}, {\n" +
            "\"lati\": 77.240899999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.559100000000001\n" +
            "}, {\n" +
            "\"lati\": 77.139099999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.798999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.164199999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.7258\n" +
            "}, {\n" +
            "\"lati\": 77.1524,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.5349\n" +
            "}, {\n" +
            "\"lati\": 77.165700000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.742899999999999\n" +
            "}, {\n" +
            "\"lati\": 77.042500000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.796500000000002\n" +
            "}, {\n" +
            "\"lati\": 77.0518,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.724499999999999\n" +
            "}, {\n" +
            "\"lati\": 77.137799999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.633600000000001\n" +
            "}, {\n" +
            "\"lati\": 77.214299999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.498899999999999\n" +
            "}, {\n" +
            "\"lati\": 77.1828,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.635000000000002\n" +
            "}, {\n" +
            "\"lati\": 77.1571,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.716799999999999\n" +
            "}, {\n" +
            "\"lati\": 77.159800000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.684200000000001\n" +
            "}, {\n" +
            "\"lati\": 77.119299999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.697800000000001\n" +
            "}, {\n" +
            "\"lati\": 77.208500000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.665400000000002\n" +
            "}, {\n" +
            "\"lati\": 77.214299999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.629999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.244200000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.592400000000001\n" +
            "}, {\n" +
            "\"lati\": 77.240600000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.6419\n" +
            "}, {\n" +
            "\"lati\": 77.0916,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.6966\n" +
            "}, {\n" +
            "\"lati\": 77.306600000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.666799999999999\n" +
            "}, {\n" +
            "\"lati\": 77.218800000000002,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.6556\n" +
            "}, {\n" +
            "\"lati\": 77.078599999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.7026\n" +
            "}, {\n" +
            "\"lati\": 77.276399999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.6554\n" +
            "}, {\n" +
            "\"lati\": 77.221500000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.688500000000001\n" +
            "}, {\n" +
            "\"lati\": 77.174300000000002,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.692399999999999\n" +
            "}, {\n" +
            "\"lati\": 77.101399999999998,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.638999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.082899999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.588100000000001\n" +
            "}, {\n" +
            "\"lati\": 77.146600000000007,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.6601\n" +
            "}, {\n" +
            "\"lati\": 77.099500000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.609400000000001\n" +
            "}, {\n" +
            "\"lati\": 77.209299999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.645800000000001\n" +
            "}, {\n" +
            "\"lati\": 77.211200000000005,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.654\n" +
            "}, {\n" +
            "\"lati\": 77.199100000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.5745\n" +
            "}, {\n" +
            "\"lati\": 76.982699999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.6098\n" +
            "}, {\n" +
            "\"lati\": 77.087199999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.529599999999999\n" +
            "}, {\n" +
            "\"lati\": 77.317099999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.613600000000002\n" +
            "}, {\n" +
            "\"lati\": 77.303600000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.4938\n" +
            "}, {\n" +
            "\"lati\": 77.144099999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.689\n" +
            "}, {\n" +
            "\"lati\": 77.207700000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.6692\n" +
            "}, {\n" +
            "\"lati\": 77.206500000000005,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.692499999999999\n" +
            "}, {\n" +
            "\"lati\": 77.203199999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 3\n" +
            "},\n" +
            "\"longi\": 28.6386\n" +
            "}, {\n" +
            "\"lati\": 77.211200000000005,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.598299999999998\n" +
            "}, {\n" +
            "\"lati\": 77.240499999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.5684\n" +
            "}, {\n" +
            "\"lati\": 77.280699999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.667000000000002\n" +
            "}, {\n" +
            "\"lati\": 77.233699999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.604199999999999\n" +
            "}, {\n" +
            "\"lati\": 77.313100000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.655999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.156199999999998,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.758400000000002\n" +
            "}, {\n" +
            "\"lati\": 77.232799999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.554099999999998\n" +
            "}, {\n" +
            "\"lati\": 77.068299999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.629999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.064899999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.625\n" +
            "}, {\n" +
            "\"lati\": 77.233400000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.564699999999998\n" +
            "}, {\n" +
            "\"lati\": 77.292400000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.562100000000001\n" +
            "}, {\n" +
            "\"lati\": 77.231499999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.662500000000001\n" +
            "}, {\n" +
            "\"lati\": 77.290999999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.5016\n" +
            "}, {\n" +
            "\"lati\": 77.281999999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.540500000000002\n" +
            "}, {\n" +
            "\"lati\": 77.066999999999993,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 3\n" +
            "},\n" +
            "\"longi\": 28.681999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.198599999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.558499999999999\n" +
            "}, {\n" +
            "\"lati\": 77.225499999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.6434\n" +
            "}, {\n" +
            "\"lati\": 77.066699999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.578399999999998\n" +
            "}, {\n" +
            "\"lati\": 77.101200000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.671099999999999\n" +
            "}, {\n" +
            "\"lati\": 77.067400000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.6205\n" +
            "}, {\n" +
            "\"lati\": 77.235399999999998,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.618200000000002\n" +
            "}, {\n" +
            "\"lati\": 77.119600000000005,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.651499999999999\n" +
            "}, {\n" +
            "\"lati\": 77.242999999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.509599999999999\n" +
            "}, {\n" +
            "\"lati\": 77.303700000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.607299999999999\n" +
            "}, {\n" +
            "\"lati\": 77.078900000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.747699999999998\n" +
            "}, {\n" +
            "\"lati\": 77.267300000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.659600000000001\n" +
            "}, {\n" +
            "\"lati\": 77.058499999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.5641\n" +
            "}, {\n" +
            "\"lati\": 77.158699999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.647500000000001\n" +
            "}, {\n" +
            "\"lati\": 77.036000000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 3\n" +
            "},\n" +
            "\"longi\": 28.6538\n" +
            "}, {\n" +
            "\"lati\": 77.227199999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.5288\n" +
            "}, {\n" +
            "\"lati\": 77.270300000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.637799999999999\n" +
            "}, {\n" +
            "\"lati\": 77.295299999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.638500000000001\n" +
            "}, {\n" +
            "\"lati\": 77.135099999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.640499999999999\n" +
            "}, {\n" +
            "\"lati\": 77.208500000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.549399999999999\n" +
            "}, {\n" +
            "\"lati\": 77.022800000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.8066\n" +
            "}, {\n" +
            "\"lati\": 77.120999999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.730399999999999\n" +
            "}, {\n" +
            "\"lati\": 77.247200000000007,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.627400000000002\n" +
            "}, {\n" +
            "\"lati\": 77.225099999999998,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 3\n" +
            "},\n" +
            "\"longi\": 28.575900000000001\n" +
            "}, {\n" +
            "\"lati\": 77.124399999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.598700000000001\n" +
            "}, {\n" +
            "\"lati\": 77.193299999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.6526\n" +
            "}, {\n" +
            "\"lati\": 77.113299999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 3\n" +
            "},\n" +
            "\"longi\": 28.657599999999999\n" +
            "}, {\n" +
            "\"lati\": 77.283900000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.643599999999999\n" +
            "}, {\n" +
            "\"lati\": 77.158199999999994,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.6524\n" +
            "}, {\n" +
            "\"lati\": 77.169300000000007,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.558\n" +
            "}, {\n" +
            "\"lati\": 77.193200000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.6526\n" +
            "}, {\n" +
            "\"lati\": 77.260199999999998,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.578399999999998\n" +
            "}, {\n" +
            "\"lati\": 77.088499999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.853200000000001\n" +
            "}, {\n" +
            "\"lati\": 77.311800000000005,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 4\n" +
            "},\n" +
            "\"longi\": 28.598199999999999\n" +
            "}, {\n" +
            "\"lati\": 77.213700000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.624700000000001\n" +
            "}, {\n" +
            "\"lati\": 77.071700000000007,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.664999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.306100000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.625399999999999\n" +
            "}, {\n" +
            "\"lati\": 77.1785,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.680599999999998\n" +
            "}, {\n" +
            "\"lati\": 77.306100000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.625399999999999\n" +
            "}, {\n" +
            "\"lati\": 76.966800000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.628699999999998\n" +
            "}, {\n" +
            "\"lati\": 76.994699999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.5869\n" +
            "}, {\n" +
            "\"lati\": 77.180199999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.5215\n" +
            "}, {\n" +
            "\"lati\": 77.146000000000001,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.700399999999998\n" +
            "}, {\n" +
            "\"lati\": 77.081900000000005,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 3\n" +
            "},\n" +
            "\"longi\": 28.628599999999999\n" +
            "}, {\n" +
            "\"lati\": 77.183700000000002,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.668399999999998\n" +
            "}, {\n" +
            "\"lati\": 77.192599999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.670000000000002\n" +
            "}, {\n" +
            "\"lati\": 77.202600000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.684999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.152299999999997,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.5349\n" +
            "}, {\n" +
            "\"lati\": 77.118200000000002,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.7089\n" +
            "}, {\n" +
            "\"lati\": 77.332700000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.6249\n" +
            "}, {\n" +
            "\"lati\": 77.316500000000005,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.678100000000001\n" +
            "}, {\n" +
            "\"lati\": 77.268600000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.674299999999999\n" +
            "}, {\n" +
            "\"lati\": 77.298599999999993,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.6828\n" +
            "}, {\n" +
            "\"lati\": 77.285200000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.674199999999999\n" +
            "}, {\n" +
            "\"lati\": 77.256100000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.711099999999998\n" +
            "}, {\n" +
            "\"lati\": 77.291700000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.696100000000001\n" +
            "}, {\n" +
            "\"lati\": 77.3185,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.706\n" +
            "}, {\n" +
            "\"lati\": 76.960800000000006,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.670400000000001\n" +
            "}, {\n" +
            "\"lati\": 77.264399999999995,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 3\n" +
            "},\n" +
            "\"longi\": 28.7013\n" +
            "}, {\n" +
            "\"lati\": 77.272999999999996,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.679099999999998\n" +
            "}, {\n" +
            "\"lati\": 77.274799999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.673400000000001\n" +
            "}, {\n" +
            "\"lati\": 77.308199999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.698499999999999\n" +
            "}, {\n" +
            "\"lati\": 77.316000000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.684999999999999\n" +
            "}, {\n" +
            "\"lati\": 77.262100000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 0\n" +
            "},\n" +
            "\"longi\": 28.672000000000001\n" +
            "}, {\n" +
            "\"lati\": 77.256100000000004,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.711300000000001\n" +
            "}, {\n" +
            "\"lati\": 77.274500000000003,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 2\n" +
            "},\n" +
            "\"longi\": 28.732800000000001\n" +
            "}, {\n" +
            "\"lati\": 77.280799999999999,\n" +
            "\"type\": \"Feature\",\n" +
            "\"properties\": {\n" +
            "\"mag\": 1\n" +
            "},\n" +
            "\"longi\": 28.702200000000001\n" +
            "}]}";
}