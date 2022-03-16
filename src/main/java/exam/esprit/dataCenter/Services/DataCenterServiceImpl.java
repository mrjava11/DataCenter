package exam.esprit.dataCenter.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import exam.esprit.dataCenter.Entities.DataCenter;
import exam.esprit.dataCenter.Entities.VirtualMachine;
import exam.esprit.dataCenter.Repos.DataCenterRepository;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DataCenterServiceImpl implements IDataCenterService {

	@Autowired
	
	DataCenterRepository dataCenterRepository;

	@Override
	public void ajouterDc(DataCenter dataCenter) {
		// TODO Auto-generated method stub
		dataCenterRepository.save(dataCenter);
	}

	@Override
	public List<DataCenter> listerDataCenter() {
		// TODO Auto-generated method stub
		return dataCenterRepository.listerDataCenter();
	}
	
	
	@Scheduled(cron="*/10 * * * * *")
	public void getDataCenters(){
		for(DataCenter dataCenter:listerDataCenter()){
			log.info("Data Center : "+dataCenter.getRegion());
			for(VirtualMachine vm:dataCenter.getVms()){
				log.info("OS : "+vm.getOs());
			}
		}
	}
	
	
}
