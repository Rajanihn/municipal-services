package org.egov.fsm.config;

import java.util.TimeZone;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Component
public class FSMConfiguration {
	
	

		@Value("${app.timezone}")
		private String timeZone;

		@PostConstruct
		public void initialize() {
			TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
		}

		// User Config
		@Value("${egov.user.host}")
		private String userHost;

		@Value("${egov.user.context.path}")
		private String userContextPath;

		@Value("${egov.user.create.path}")
		private String userCreateEndpoint;

		@Value("${egov.user.search.path}")
		private String userSearchEndpoint;

		@Value("${egov.user.update.path}")
		private String userUpdateEndpoint;

		@Value("${egov.user.username.prefix}")
		private String usernamePrefix;

		// Idgen Config
		@Value("${egov.idgen.host}")
		private String idGenHost;

		@Value("${egov.idgen.path}")
		private String idGenPath;

		@Value("${egov.idgen.fsm.applicationNum.name}")
		private String applicationNoIdgenName;

		@Value("${egov.idgen.fsm.applicationNum.format}")
		private String applicationNoIdgenFormat;


		// Persister Config
		@Value("${persister.save.fsm.topic}")
		private String saveTopic;

		@Value("${persister.update.fsm.topic}")
		private String updateTopic;

		
		@Value("${persister.update.fsm.workflow.topic}")
		private String updateWorkflowTopic;

		@Value("${persister.update.fsm.adhoc.topic}")
		private String updateAdhocTopic;

		// Location Config
		@Value("${egov.location.host}")
		private String locationHost;

		@Value("${egov.location.context.path}")
		private String locationContextPath;

		@Value("${egov.location.endpoint}")
		private String locationEndpoint;

		@Value("${egov.location.hierarchyTypeCode}")
		private String hierarchyTypeCode;

		@Value("${egov.fsm.default.limit}")
		private Integer defaultLimit;

		@Value("${egov.fsm.default.offset}")
		private Integer defaultOffset;

		@Value("${egov.fsm.max.limit}")
		private Integer maxSearchLimit;



		// Reciept
		@Value("${kafka.topics.receipt.create}")
		private String receiptCreateTopic;

		@Value("${egov.receipt.businessservice}")
		private String businessService;

		// Property Service
		@Value("${egov.property.service.host}")
		private String propertyHost;

		@Value("${egov.property.service.context.path}")
		private String propertyContextPath;

		@Value("${egov.property.endpoint}")
		private String propertySearchEndpoint;

		// SMS
		@Value("${kafka.topics.notification.sms}")
		private String smsNotifTopic;

		@Value("${notification.sms.enabled}")
		private Boolean isSMSEnabled;

		// Localization
		@Value("${egov.localization.host}")
		private String localizationHost;

		@Value("${egov.localization.context.path}")
		private String localizationContextPath;

		@Value("${egov.localization.search.endpoint}")
		private String localizationSearchEndpoint;

		@Value("${egov.localization.statelevel}")
		private Boolean isLocalizationStateLevel;

		// Calculator
		@Value("${egov.fsm.calculator.host}")
		private String calculatorHost;

		@Value("${egov.fsm.calculator.calculate.endpoint}")
		private String calulatorEndPoint;

		@Value("${egov.billingservice.host}")
		private String billingHost;

		@Value("${egov.demand.search.endpoint}")
		private String demandSearchEndpoint;

		// MDMS
		@Value("${egov.mdms.host}")
		private String mdmsHost;

		@Value("${egov.mdms.search.endpoint}")
		private String mdmsEndPoint;

		// Allowed Search Parameters
		@Value("${citizen.allowed.search.params}")
		private String allowedCitizenSearchParameters;

		@Value("${employee.allowed.search.params}")
		private String allowedEmployeeSearchParameters;

	

		// Workflow
		@Value("${create.fsm.workflow.name}")
		private String businessServiceValue;

		@Value("${workflow.context.path}")
		private String wfHost;

		@Value("${workflow.transition.path}")
		private String wfTransitionPath;

		@Value("${workflow.businessservice.search.path}")
		private String wfBusinessServiceSearchPath;

		@Value("${workflow.process.path}")
		private String wfProcessPath;

		// USER EVENTS
		@Value("${egov.ui.app.host}")
		private String uiAppHost;

		@Value("${egov.usr.events.create.topic}")
		private String saveUserEventsTopic;

		@Value("${egov.usr.events.pay.link}")
		private String payLink;

		@Value("${egov.usr.events.pay.code}")
		private String payCode;

		@Value("${egov.user.event.notification.enabled}")
		private Boolean isUserEventsNotificationEnabled;

		@Value("${egov.usr.events.pay.triggers}")
		private String payTriggers;

		@Value("${egov.collection.service.host}")
		private String collectionServiceHost;

		@Value("${egov.collection.service.search.endpoint}")
		private String collectionServiceSearchEndPoint;

		
		
		
		
}
