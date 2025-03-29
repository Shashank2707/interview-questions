package com.test.lld.question.carrentaldesign;

import java.util.ArrayList;
import java.util.List;

public class VehicleRentalSystem {

    List<Store> storeList;
    List<User> userList;

    VehicleRentalSystem(List<Store> stores, List<User> users) {

        this.storeList = stores;
        this.userList = users;
    }


    public List<Store> getStore(List<Location> location){

        //based on location, we will filter out the Store from storeList.
//        return storeList.get(0);
    	List<Store> store = new ArrayList<>();
    	for(int i = 0; i < location.size(); i++)
    	{
    		if(this.userList.get(0).getLocation().getCity().equalsIgnoreCase(location.get(i).getCity()))
    		{
    			store.add(storeList.get(i));
    		}
    	}
    	return store;
    }



    //addUsers

    //remove users


    //add stores

    //remove stores



}
