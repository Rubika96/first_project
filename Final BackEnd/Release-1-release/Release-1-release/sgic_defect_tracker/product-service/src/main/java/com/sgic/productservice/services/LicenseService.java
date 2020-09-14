package com.sgic.productservice.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sgic.productservice.dto.LicenseDTO;
import com.sgic.productservice.dto.LicenseNameDTO;
import com.sgic.productservice.dto.mapping.LicenseDTOMapping;
import com.sgic.productservice.entities.License;
import com.sgic.productservice.entity.mapping.LicenseMapping;
import com.sgic.productservice.entity.mapping.LicenseNameMapping;
import com.sgic.productservice.repositories.LicenseRepository;

@Service
public class LicenseService {
	@Autowired
	private LicenseRepository licenseRepository;
	
	public License saveLicense(LicenseDTO licenseDto) {
		return licenseRepository.save(LicenseDTOMapping.licenseDTOToLicense(licenseDto));
	}
		
    public List<LicenseDTO> getAllLicense() {
        return LicenseMapping.licenseDTOListToLicenseList(licenseRepository.findAll());
    	//return LicenseDTOMapping.licenseDTOToLicense(licenseRepository.findAll())
    }
    public List<LicenseNameDTO> getAllLicenseName() {
		// TODO Auto-generated method stub
		return LicenseNameMapping.licenseNameDTOListToLicenseList(licenseRepository.findAll());
	}
		
	public LicenseDTO getLicenseById(Long licenseId) {
		return LicenseMapping.licenseTolicenseDTO(licenseRepository.findById(licenseId).orElse(null));
	}
	
	public License updateLicense(Long licenseId,LicenseDTO licenseDto) {
		return (licenseRepository.findById(licenseId).map(license->{
			license.setLicenseName(licenseDto.getLicenseName());
			license.setLicenseValidity(licenseDto.getLicenseValidity());
			license.setLicenseCost(licenseDto.getLicenseCost());
			license.setCreated_date(licenseDto.getCreated_date());
			license.setUpdated_date(licenseDto.getUpdated_date());
			return licenseRepository.save(license);
		}).orElse(null));
	}
	
	public void deleteLicense(Long licenseId) {
		 licenseRepository.findById(licenseId).map(license->{
			  licenseRepository.delete(license);
			  return null;
		 }).orElse(null);
	}

	
}
