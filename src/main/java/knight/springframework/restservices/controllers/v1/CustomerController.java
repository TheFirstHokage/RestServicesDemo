package knight.springframework.restservices.controllers.v1;

import knight.springframework.restservices.api.v1.mod.CategoryDTO;
import knight.springframework.restservices.api.v1.mod.CustomerDTO;
import knight.springframework.restservices.api.v1.mod.CustomerListDTO;
import knight.springframework.restservices.services.CustomerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(CustomerController.BASE_URL)
public class CustomerController {

    public static final String BASE_URL ="/api/v1/customers";
    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public CustomerListDTO getListOfCustomers() {

        return new  CustomerListDTO(customerService.getAllCustomers());
    }


    @GetMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO findCustomerById(@PathVariable Long id) {
        return customerService.findCustomerById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CustomerDTO createNewCustomer(@RequestBody CustomerDTO customerDTO) {

        return customerService.createNewCustomer(customerDTO);


    }


    @PutMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO updateCustomer(@PathVariable Long id,@RequestBody CustomerDTO customerDTO) {

        return customerService.saveCustomerByDTO(id,customerDTO);

    }

    @PatchMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public CustomerDTO patchCustomer(@PathVariable Long id,@RequestBody CustomerDTO customerDTO) {

        return customerService.patchCustomer(id,customerDTO);

    }

    @DeleteMapping({"/{id}"})
    @ResponseStatus(HttpStatus.OK)
    public void deleteCustomer(@PathVariable Long id) {
        customerService.deleteCustomerById(id);

    }

}
