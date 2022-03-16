package exam.esprit.dataCenter.RestController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import exam.esprit.dataCenter.Entities.DataCenter;
import exam.esprit.dataCenter.Entities.User;
import exam.esprit.dataCenter.Entities.VirtualMachine;
import exam.esprit.dataCenter.Services.IDataCenterService;
import exam.esprit.dataCenter.Services.IUserService;
import exam.esprit.dataCenter.Services.IVirtualMachineService;

@RestController
@RequestMapping("/data-center")
public class DataCenterRestController {

	@Autowired
	IUserService userService;
	
	@Autowired
	IVirtualMachineService virtualMachineService;
	
	@Autowired
	IDataCenterService dataCenterService;
	
	// http://localhost:4070/DataCenter/data-center/...
	
	@PostMapping("/ajouter-user")
	public void ajouterUser(@RequestBody User user){
		userService.ajouterUser(user);
	}
	
	
	@PostMapping("/ajouter-dc")
	public void ajouterDc(@RequestBody DataCenter dataCenter){
		dataCenterService.ajouterDc(dataCenter);
	}
	
	
	@PostMapping("/ajouter-vm")
	public void ajouterVm(@RequestBody VirtualMachine vm){
		virtualMachineService.ajouterVm(vm);
	}
	
	
	@PutMapping("/affecter-vm-user/{id-vm}/{id-user}")
	public void affecterVmUser(@PathVariable("id-vm") int idVm, @PathVariable("id-user") int idUser){
		virtualMachineService.affecterVmUser(idVm, idUser);
	}
	
	
	@PutMapping("/affecter-vm/{id-vm}")
	public void affecterVm(@PathVariable("id-vm") int idVm){
		virtualMachineService.affecterVm(idVm);
	}
	
	
	@PutMapping("/demarrer-vm/{id-vm}")
	public void demarrerVm(@PathVariable("id-vm") int idVm){
		virtualMachineService.demarrerInstanceUser(idVm);;
	}
	
	
	@PutMapping("/arreter-vm/{id-vm}")
	public void arreterVm(@PathVariable("id-vm") int idVm){ 
		virtualMachineService.arreterInstanceUser(idVm);
	}
	
	
	
	@GetMapping("/getDataCenters")
	public List<DataCenter> getDataCenter(){
		return dataCenterService.listerDataCenter();
	}
	
	
	
}
