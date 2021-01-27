package org.egov.vendor.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.egov.common.contract.request.RequestInfo;
import org.egov.tracer.model.CustomException;
import org.egov.vendor.repository.VendorRepository;
import org.egov.vendor.validator.VendorValidator;
import org.egov.vendor.web.model.Vendor;
import org.egov.vendor.web.model.VendorRequest;
import org.egov.vendor.web.model.VendorSearchCriteria;
import org.egov.vendor.web.model.user.UserDetailResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Autowired
	private VendorValidator vendorValidator;

	@Autowired
	private VendorRepository repository;


	@Autowired
	private EnrichmentService enrichmentService;
	

	public Vendor create(VendorRequest vendorRequest) {
		RequestInfo requestInfo = vendorRequest.getRequestInfo();
		String tenantId = vendorRequest.getVendor().getTenantId().split("\\.")[0];
		if (vendorRequest.getVendor().getTenantId().split("\\.").length == 1) {
			throw new CustomException("Invalid TenantId", " Application cannot be create at StateLevel");
		}

		vendorValidator.validateCreate(vendorRequest);
		enrichmentService.enrichCreate(vendorRequest);
		vendorRepository.save(vendorRequest);
		return vendorRequest.getVendor();

	}

	public List<Vendor> Vendorsearch(VendorSearchCriteria criteria, RequestInfo requestInfo) {

		List<Vendor> vendorList = new LinkedList<>();
		List<String> uuids = new ArrayList<String>();
		UserDetailResponse vendorRespnse;

		vendorValidator.validateSearch(requestInfo, criteria);
		/*
		 * if (criteria.getMobileNumber() != null) { vendorRespnse =
		 * ownerService.getOwner(criteria, requestInfo); if (vendorRespnse != null &&
		 * vendorRespnse.getOwner() != null && vendorRespnse.getOwner().size() > 0) {
		 * uuids =
		 * vendorRespnse.getOwner().stream().map(User::getUuid).collect(Collectors.
		 * toList()); criteria.setOwnerIds(uuids); } }
		 */
		vendorList = repository.getVendorData(criteria);

		if (vendorList.isEmpty()) {
			return Collections.emptyList();
		}

		return vendorList;

	}

}