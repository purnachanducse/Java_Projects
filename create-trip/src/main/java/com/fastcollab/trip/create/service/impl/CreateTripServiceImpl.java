package com.fastcollab.trip.create.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fastcollab.trip.create.dao.AirportRepository;
import com.fastcollab.trip.create.dao.CityRepo;
import com.fastcollab.trip.create.dao.CreateTripDao;
//import com.fastcollab.trip.create.dto.FareOption;
import com.fastcollab.trip.create.dto.Flight;
//import com.fastcollab.trip.create.dto.FlightOptions;
//import com.fastcollab.trip.create.dto.FlightRequests;
import com.fastcollab.trip.create.entity.AirportEntity;
import com.fastcollab.trip.create.entity.CityEntity;
import com.fastcollab.trip.create.entity.FlightOptions;
import com.fastcollab.trip.create.entity.FlightRequests;
//import com.fastcollab.trip.create.dto.JourneyDetails;
/*import com.fastcollab.trip.create.dto.FlightOptions;
import com.fastcollab.trip.create.dto.FlightRequests;
import com.fastcollab.trip.create.dto.JourneyDetails;*/
import com.fastcollab.trip.create.dto.PaxFare;
import com.fastcollab.trip.create.dto.PaxType;
import com.fastcollab.trip.create.dto.Segment;
import com.fastcollab.trip.create.entity.TripMaster;
//import com.fastcollab.trip.create.dto.TripMaster;
import com.fastcollab.trip.create.entity.TripMaster;
//import com.fastcollab.trip.create.dto.TripMaster;
import com.fastcollab.trip.create.service.CreateTripService;
import com.fastcollab.trip.create.util.FastCollabCommonUtil;

@Service("tripService")
@Transactional
public class CreateTripServiceImpl implements CreateTripService {
	@Autowired
	private CreateTripDao createTripDao;
	
	@Autowired
	private CityRepo cityRepo;
	
	@Autowired
	private AirportRepository airportRepository;


	@Override
	public String createApi(Flight flight) {
		System.out.println("createApi start");
		TripMaster master=tripDtoToEntity(flight);
		System.out.println("createApi start");
		//createTripDao.saveAll(master);
		createTripDao.saveAndFlush(master);
		return "TRIP100";
	}

	@Override
	public TripMaster tripDtoToEntity(Flight flight) {
		Long userid=flight.getUserId();
		
		
		TripMaster tripMaster=new TripMaster();
		List<Segment> flightSegments=flight.getSegments();
		List<FareOption> fare=flight.getFareOption();
		List<FlightOptions> flightOptionsList=new ArrayList<>();
		FlightOptions flightOptions=new FlightOptions();
		List<FlightRequests> flightRequestList=new ArrayList<>();
		FlightRequests flightRequests=new FlightRequests();
		JourneyDetails journeyDetails=new JourneyDetails();
				
		//Trip_master mapping
		tripMaster.setGuid(FastCollabCommonUtil.generateRandomKey());
		
		tripMaster.setUserId(userid);
		tripMaster.setCreatedBy(userid);
		tripMaster.setUpdatedBy(userid);
		tripMaster.setStatusId(flight.getStatusId());
		tripMaster.setEmailRequest(false);
		tripMaster.setCreatedDate(new Date());
		tripMaster.setUpdatedDate(new Date());

		flightRequests.setGuid(FastCollabCommonUtil.generateRandomKey());
		flightRequests.setStatusId(flight.getStatusId());
		flightRequests.setTravelType(flight.getTravelType());
		flightRequests.setTravelMode(flight.getTravelMode());
		List<FareOption> fareOptions = flight.getFareOption();
		for(FareOption fareOption:fareOptions){
			if(fareOption.getFareKey().equals(flight.getFareKey())){
				flightRequests.setPrice(fareOption.getFare().getTicketPrice());
				flightOptions.setFareType(fareOption.getFareType());
				flightOptions.setPrice(fareOption.getFare().getTicketPrice());
				flightOptions.setBaseFare(fareOption.getFare().getBasePrice());
				flightOptions.setTaxFare(fareOption.getFare().getTax());
				//Paxfare if Farekey matches
				List<PaxFare> paxfares=fareOption.getPaxFares();
				for (PaxFare paxFare:paxfares) {
					if(paxFare.getPaxType().equals(PaxType.ADT)){
						flightRequests.setAdultCount(paxFare.getPaxCount()); 
					}else if(paxFare.getPaxType().equals(PaxType.CHD)){
						flightRequests.setChildCount(paxFare.getPaxCount()); 
					}else if(paxFare.getPaxType().equals(PaxType.INF)){
						flightRequests.setInfantCount(paxFare.getPaxCount());
					}
					
				}
			}
		}
		List<Segment> segments = flight.getSegments();
		int segSize = segments.size();
		if(segSize > 0){
			//flightRequests.setDepartureDate(segments.get(0).getDepartureDateTime());
			//flightRequests.setReturnDate(segments.get(segSize-1).getArrivalDateTime());
			flightOptions.setDepartureAirportCode(segments.get(0).getDepartureAirportCode());
			flightOptions.setArrivalAirportCode(segments.get(segSize-1).getArrivalAirportCode());
			//flightOptions.setDepartureDate(segments.get(0).getDepartureDateTime());
			//flightOptions.setArrivalDate(segments.get(segSize-1).getArrivalDateTime());
			flightOptions.setDepartureTerminal(segments.get(0).getDepartureTerminal());
			flightOptions.setArrivalTerminal(segments.get(segSize-1).getArrivalTerminal());
			//tripMaster.setTripName(""+"TO"+journeyDetails.getToCityId());
			//List<String> airportNames=findByAirportCode(Arrays.asList(segments.get(0).getDepartureAirportCode(),segments.get(segSize-1).getArrivalAirportCode()));
			//	System.out.println(airportNames);
//				flightOptions.setDepartureAirportName(airportNames.get(0));
//				flightOptions.setArrivalAirportName(airportNames.get(1));
		}
		
		//flightRequests.setCabinClass((flight.geT);
		
		
		flightRequests.setAdultCount(flight.getTravelType());
		flightRequests.setTravelType(flight.getTravelType());
		flightRequests.setTravelType(flight.getTravelType());
		
		flightOptions.setTripIndicator(flight.getTripIndicator());
		flightOptions.setFareBasisCode(flight.getFareBasisCode());
		//Need to add fare basee class here
		//flightOptions.setFareBaseClass(flight.getFare);
		//Need to add Airline NAme
		//flightOptions.set(flight.getTripIndicator());
		flightOptions.setAirlineCode(flight.getValidatingAirline());
		flightOptions.setTripIndicator(flight.getTripIndicator());
		flightRequestList.add(flightRequests);
		flightSegments = flightOptions.get
		flightOptions.setFlightSegments(segments);
		
		flightOptions.setFlightPassengers(flightPassengers);
		flightOptionsList.add(flightOptions);
		flightRequests.setFlightOptions(flightOptionsList);
		
		
		//flightRequests.setJourneyDetails();
		tripMaster.setFlightRequests(flightRequestList);
		String fromCityId=String.valueOf(journeyDetails.getFromCityId());
		String toCityId=String.valueOf(journeyDetails.getFromCityId());
		//
		List<String> cityNames=findByCityCode(Arrays.asList("HYD","BNG"));
		System.out.println("Entity:"+cityNames+" name"+cityNames.get(0));
		tripMaster.setTripName(cityNames.get(0)+" to "+cityNames.get(1));
		return tripMaster;
	}

	@Override
	public List<String> findByCityCode(List<String> cityCodes) {
		return cityRepo.findByCityCode(cityCodes);
	}

	@Override
	public List<String> findByAirportCode(List<String> airportCodes) {
		return airportRepository.findByAirportCode(airportCodes);
	}

}