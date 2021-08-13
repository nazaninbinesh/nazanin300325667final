package com.example.nazanin300325667;

import jdk.jfr.Category;

import javax.xml.crypto.Data;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


@SessionAttributes({"id","name","errMsg","errorMessage"})
@RequestMapping
@Controller
public class MyController {
    //DatabaseService service1;
    DatabaseInterface service1;

    @Autowired
    CustomerService service;

    @Autowired
    Connection123 connect;

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String showCustomerPage(ModelMap model,@RequestParam(defaultValue = "") String id) throws ClassNotFoundException, SQLException{
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos", service1.display());

        List<Category> filteredCustomers = new ArrayList<Category>();

        filteredTodos = (List) model.get("cutomerList");

        model.put("custno",filteredCustomers.get(0).get);
        model.put("desc",filteredCustomers.get(0).getCatDesc());
        model.put("color",filteredCustomers.get(0).getCatColor());

        return "category";
    }
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String showCategorypage2(ModelMap model) throws ClassNotFoundException, SQLException{
        service1 = new DatabaseService(connect.connect());
        model.addAttribute("todos", service1.display());
        List<Category> filteredTodos = new ArrayList<Category>();
        filteredTodos =(List) model.get("todos");
        model.put("id",filteredTodos.get(0).getCatcode());
        model.put("desc",filteredTodos.get(0).getCatDesc());
        model.put("color",filteredTodos.get(0).getCatColor());
        return "category";
    }
    @RequestMapping(value = "/add-todo", method = RequestMethod.GET)
    public String showTodopage(){
        return "catser";
    }

    @RequestMapping(value = "/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String catcode, @RequestParam String catDesc, @RequestParam String catColor) throws SQLException, ClassNotFoundException{
        if(!((service1.search(catcode))==null)){
            model.put("errorMessage","Record Existing");
            return "redirect:/category";
        }
        Category cc = new Category(catcode, catDesc, catColor);
        service1.add(cc);
        model.clear();
        return "redirect:/category";
    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model,  @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException{

        model.put("id", id);

        // model.addAttribute("category",service.retrieve(id));

        Category cc = service1.search(id);

        model.put("id",cc.getCatcode());
        model.put("desc", cc.getCatDesc());
        model.put("color", cc.getCatColor());

        return "catedit";
    }



    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model,  @RequestParam String catcode, @RequestParam String catdesc,@RequestParam String catColor) throws SQLException, ClassNotFoundException{

        String iid = (String) model.get("id");
        Category cc = new Category(catcode,catdesc,catColor);

        service1.edit(cc, iid);

        return "redirect:/";

    }

    @RequestMapping(value = "/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String id) throws SQLException, ClassNotFoundException {
        service1.delete(id);
        model.clear();
        return "redirect:/";
    }

    @RequestMapping(value ="/see-todo", method = RequestMethod.GET)
    public String seetodo(ModelMap model, @RequestParam(defaultValue = "") String id) throws SQLException, ClassNotFoundException {
        model.put("id", id);
        service1 = new DatabaseService(connect.connect());
        String iid = (String) model.get("id");
        List<Items> Itemlist = new ArrayList<>();
        Itemlist = service1.display2(iid);
        if(Itemlist.size()==0){
            model.put("errorMessage","There are not items for this category ");
            return "redirect:/";
        }
        model.put("desc",iid);
        System.out.println(iid);
        model.addAttribute("todos1", service1.display2(iid));
        return "items";
    }
    @RequestMapping(value ="/see-todo", method = RequestMethod.POST)
    public String seetodo2(ModelMap model) throws SQLException, ClassNotFoundException {
        return "redirect:/";
    }



}
