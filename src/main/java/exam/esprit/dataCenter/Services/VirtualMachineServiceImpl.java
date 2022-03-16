package exam.esprit.dataCenter.Services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exam.esprit.dataCenter.Entities.DataCenter;
import exam.esprit.dataCenter.Entities.Etat;
import exam.esprit.dataCenter.Entities.User;
import exam.esprit.dataCenter.Entities.VirtualMachine;
import exam.esprit.dataCenter.Repos.DataCenterRepository;
import exam.esprit.dataCenter.Repos.UserRepository;
import exam.esprit.dataCenter.Repos.VirtualMachineRepository;


@Service
public class VirtualMachineServiceImpl implements IVirtualMachineService {
	
	@Autowired
	VirtualMachineRepository virtualMachineRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	DataCenterRepository dataCenterRepository;

	@Override
	public int ajouterVm(VirtualMachine vm) {
	
		return virtualMachineRepository.save(vm).getIdVm();
	}

	@Override
	public void affecterVmUser(int idVm, int idUser) {
		
		VirtualMachine vm = virtualMachineRepository.findById(idVm).orElse(null);
		User user = userRepository.findById(idUser).orElse(null);
		user.getVms().add(vm);
		userRepository.save(user);
	}

	@Transactional
	@Override
	public void affecterVm(int idVm) {
		VirtualMachine vm = virtualMachineRepository.findById(idVm).orElse(null);
		for(DataCenter dataCenter:dataCenterRepository.findAll()){
			if(dataCenter.getEspaceLibreDisque() > vm.getTailleDisque()){
				int nouveauEspaceLibreDisque = dataCenter.getEspaceLibreDisque() - vm.getTailleDisque();
				dataCenter.setEspaceLibreDisque(nouveauEspaceLibreDisque);
				vm.setDataCenter(dataCenter);
			}
		}
	}

	@Override
	public void demarrerInstanceUser(int idVm) {
		VirtualMachine vm = virtualMachineRepository.findById(idVm).orElse(null);
		vm.setEtat(Etat.RUNNING);
		virtualMachineRepository.save(vm);
	}

	@Transactional
	@Override
	public void arreterInstanceUser(int idVm) {
		VirtualMachine vm = virtualMachineRepository.findById(idVm).orElse(null);
		vm.setEtat(Etat.STOPPED);
	}
}
