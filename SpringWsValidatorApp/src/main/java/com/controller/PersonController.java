package com.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.model.Person;
import com.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {

	@Autowired
	private PersonService personService;
	
	@RequestMapping("/welcome")
	public String welcome(){
		return "Welcome to spring boot web sevices";
	}
	
	@RequestMapping(path="/all", produces=MediaType.APPLICATION_JSON_VALUE)
	public List<Person> getAll(){
		return personService.getAll();
	}
	
	//@RequestParam :: http://localhost:8080/person/personid?id=1
	@RequestMapping(path="/personid", produces=MediaType.APPLICATION_JSON_VALUE)
	public Person getById(@RequestParam("id") Integer id){
		return personService.getById(id);
	}
	
	//@RequestParam :: another version :: http://localhost:8080/person/?id=1
	@RequestMapping(path="/", produces=MediaType.APPLICATION_JSON_VALUE)
	public Person getById1(@RequestParam("id") Integer id){
		return personService.getById(id);
	}
	
	//@PathVariable :: http://localhost:8080/person/personid/1
	@RequestMapping(path="/personid/{id}", produces=MediaType.APPLICATION_JSON_VALUE)
	public Person getById2(@PathVariable("id") Integer id){
		return personService.getById(id);
	}
	
	//#Consumes
	@RequestMapping(path="/conzume", 
			method=RequestMethod.POST,
			consumes=MediaType.APPLICATION_JSON_VALUE,
			headers="Content-Type=application/json")
	public ResponseEntity<Person> putAllByJson(@Valid @RequestBody Person requestBody){
		if(requestBody!=null){
			personService.putFromJson(requestBody);
			//TO CHECK PERSON ADDING TO LIST OR NOT
			List<Person> persons=personService.getAll();
			for(Person u : persons){
				System.out.println(u.getName()+"==="+u.getId());
			}
			
			return ResponseEntity.badRequest().build();
		}
		else{
			return ResponseEntity.ok().build();
		}

	}
}











	/*public ResponseEntity<String> putAllByJson(@Validated @RequestBody String requestBody, Errors errors){
		if(!errors.hasErrors()){
			return new ResponseEntity<String>(
				      "Handled application/json request. Request body was: " 
				      + requestBody, 
				      new HttpHeaders(), 
				      HttpStatus.OK);
		}
		else
		return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
	}
*/
	
	//same object #consumes and #produces


/*@RequestMapping(path="/conzume", 
method=RequestMethod.POST,
consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> putAllByJson(@Validated @RequestBody String requestBody, BindingResult bindingResult){
if(bindingResult.hasErrors()){
return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);
}
return new ResponseEntity<String>(HttpStatus.OK);
}

*/
/**NOTE ::
* ret_type : ResponseEntity<String>
* ret : new ResponseEntity<String>(HttpStatus.OK)
* param : @RequestBody String requestBody
* TYPE SHOULD BE SAME  String
* */

