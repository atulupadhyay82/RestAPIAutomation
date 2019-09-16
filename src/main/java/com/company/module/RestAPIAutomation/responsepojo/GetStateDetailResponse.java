package com.company.module.RestAPIAutomation.responsepojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Main pojo class for getstatedetail API response. Will be getting multiple response for GetStateDetail, hence used list data structure here.
 * @author atupadhy
 *
 */
public class GetStateDetailResponse {

	@SerializedName("getStateDetails")
	@Expose
	private List<GetStateDetail> getStateDetails = null;

	public List<GetStateDetail> getGetStateDetails() {
		return getStateDetails;
	}

	public void setGetStateDetails(List<GetStateDetail> getStateDetails) {
		this.getStateDetails = getStateDetails;
	}

}


/*
 * Response for this API would look like
 * {
    "getStateDetails": [
        {
            "name": "Bihar",
            "population": "10000000",
            "language": "Hindi",
            "region": "north"
        },
        {
            "name": "UP",
            "population": "1000000000",
            "language": "Hindi",
            "region": "north"
        },
        {
            "name": "karnataka",
            "population": "1000000000",
            "language": "Kanada",
            "region": "South"
        },
        {
            "name": "Kerala",
            "population": "1000000000",
            "language": "Kanada",
            "region": "South"
        },
        {
            "name": "tamil nadu",
            "population": "1000000000",
            "language": "Tamil",
            "region": "South"
        },
        {
            "name": "MP",
            "population": "1000000000",
            "language": "Hindi",
            "region": "South"
        }
    ]
}
 * 
 */
