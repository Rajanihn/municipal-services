package org.egov.swservice.validator;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.egov.swservice.model.Property;
import org.egov.swservice.model.SewerageConnection;
import org.egov.swservice.model.SewerageConnectionRequest;
import org.egov.swservice.util.SewerageServicesUtil;
import org.egov.tracer.model.CustomException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ValidateProperty {

	@Autowired
	private SewerageServicesUtil sewerageServiceUtil;

	/**
	 * 
	 * @param sewerageConnectionRequest
	 *            SewerageConnectionRequest is request to be validated against
	 *            property
	 */

	public void validatePropertyCriteriaForCreateSewerage(SewerageConnectionRequest sewerageConnectionRequest) {
		Property property = sewerageConnectionRequest.getSewerageConnection().getProperty();
		if (StringUtils.isEmpty(property.getTenantId())) {
			throw new CustomException("INVALID PROPERTY", "SewerageConnection cannot be updated without tenantId");
		}
	}

	/**
	 * 
	 * @param sewarageConnectionRequest
	 *            SewarageConnectionRequest is request to be validated against
	 *            property ID
	 * @return true if property id is present otherwise return false
	 */

	public boolean isPropertyIdPresentForSewerage(SewerageConnectionRequest sewerageConnectionRequest) {
		Property property = sewerageConnectionRequest.getSewerageConnection().getProperty();
		if (StringUtils.isEmpty(property.getPropertyId())) {
			return false;
		}
		return true;
	}

	public void enrichPropertyForSewerageConnection(SewerageConnectionRequest sewerageConnectionRequest) {
		List<Property> propertyList;
		if (isPropertyIdPresentForSewerage(sewerageConnectionRequest)) {
			propertyList = sewerageServiceUtil.propertySearch(sewerageConnectionRequest);
			if(!CollectionUtils.isEmpty(propertyList)) {
				if (StringUtils.isEmpty(propertyList.get(0).getUsageCategory())) {
					throw new CustomException("INVALID SEWERAGE CONNECTION PROPERTY USAGE TYPE",
							"Sewerage connection cannot be enriched without property usage type");
				}
				sewerageConnectionRequest.getSewerageConnection().setProperty(propertyList.get(0));
			}
		} else {
//			propertyList = sewerageServiceUtil.createPropertyRequest(sewerageConnectionRequest);
			throw new CustomException("PROPERTY_NOT_FOUND",
					"No property found for sewerage connection");
		}
	}

	public void validatePropertyForConnection(List<SewerageConnection> sewerageConnectionList) {
		sewerageConnectionList.forEach(sewerageConnection -> {
			if (StringUtils.isEmpty(sewerageConnection.getProperty().getPropertyId())) {
				StringBuilder builder = new StringBuilder();
				builder.append("PROPERTY ID NOT FOUND FOR ")
						.append(sewerageConnection.getConnectionNo() == null ? sewerageConnection.getApplicationNo()
								: sewerageConnection.getConnectionNo());
				log.error("", builder.toString());
			}
		});
	}
}