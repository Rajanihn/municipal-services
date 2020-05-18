package org.egov.bpa.calculator.web.models.landinfo;

import java.util.List;

import org.egov.bpa.calculator.web.models.Address;
import org.egov.bpa.calculator.web.models.AuditDetails;
import org.egov.bpa.calculator.web.models.Unit;
import org.springframework.validation.annotation.Validated;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Validated
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LandInfo {

	@JsonProperty("id")
	private String id;

	@JsonProperty("landUid")
	private String landUid;

	@JsonProperty("landUniqueRegNo")
	private String landUniqueRegNo;

	@JsonProperty("tenantId")
	private String tenantId;

	@JsonProperty("status")
	private Status status;

	@JsonProperty("address")
	private Address address;

	@JsonProperty("ownershipCategory")
	private String ownershipCategory;

	@JsonProperty("owners")
	private List<OwnerInfo> owners;

	@JsonProperty("institution")
	private Institution institution;

	@JsonProperty("source")
	private Source source;

	@JsonProperty("channel")
	private Channel channel;

	@JsonProperty("documents")
	private List<Document> documents;

	@JsonProperty("unit")
	private List<Unit> unit;

	@JsonProperty("additionalDetails")
	private Object additionalDetails;

	@JsonProperty("auditDetails")
	private AuditDetails auditDetails;	
}
