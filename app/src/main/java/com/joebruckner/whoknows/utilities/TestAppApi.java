package com.joebruckner.whoknows.utilities;

import android.util.Log;

import com.joebruckner.whoknows.models.logic.Beacon;

import java.util.ArrayList;
import java.util.List;

public class TestAppApi implements AppApi {
	List<Beacon> beacons;
	AccountApi api;

	public TestAppApi(AccountApi api) {
		this.api = api;
		this.beacons = new ArrayList<>();
	}

	@Override public List<Beacon> getAllBeacons() {
		if (beacons.isEmpty()) for (int i = 0; i < 15; i++)
			beacons.add(new Beacon("Beacon " + i));
		return beacons;
	}

	@Override public List<Beacon> getActiveBeacons() {
		if (beacons.isEmpty()) for (int i = 0; i < 15; i++)
			beacons.add(new Beacon("Beacon " + i));
		return beacons;
	}

	@Override public List<Beacon> getPostedBeacons() {
		List<Beacon> matched = new ArrayList<>();
		for (Beacon beacon : beacons) {
			if (beacon.getName().equals(api.getName()))
				matched.add(beacon);
		}
		return matched;
	}

	@Override public void put(Beacon beacon) {
		Log.d("TestApi", "Adding " + beacon.toString());
		beacons.add(beacon);
	}

	@Override public Beacon get(long id) {
		return beacons.isEmpty() ? beacons.get(0) : null;
	}
}