package jojo.web.api.repository;

import jojo.web.api.handler.BusinessException;
import jojo.web.api.handler.CampoObrigatorioException;
import jojo.web.api.model.UserModel;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    public void save(UserModel usuario){
        if(usuario.getLogin()==null){
            throw new CampoObrigatorioException("login");
        }
        if(usuario.getPassword()==null){
            throw new CampoObrigatorioException("password");
        }
        if(usuario.getId()==null) {
            System.out.println("SAVE - Recebendo o usuário na camada de repositório");
        } else {
            System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        }
        System.out.println(usuario);
    }
    public void update(UserModel usuario){
        if(usuario.getLogin()==null){
            throw new CampoObrigatorioException("login");
        }
        if(usuario.getPassword()==null){
            throw new CampoObrigatorioException("password");
        }
        System.out.println("UPDATE - Recebendo o usuário na camada de repositório");
        System.out.println(usuario);
    }
    public void remove(Integer id){
        System.out.println(String.format("DELETE/id - Recebendo o id: %d para excluir um usuário", id));
        System.out.println(id);
    }
    public List<UserModel> listAll(){
        List<UserModel> usuarios = new ArrayList<>();
        usuarios.add(new UserModel(111, "jojo","12345"));
        usuarios.add(new UserModel(222, "mateus","98765"));
        return usuarios;
    }
    public UserModel finById(Integer id){
        System.out.println(String.format("GET/id - Recebendo o id: %d para localizar um usuário", id));
        List<UserModel> usuarios = new ArrayList<>();
        usuarios.add(new UserModel(111, "jojo","12345"));
        usuarios.add(new UserModel(222, "mateus","98765"));
        for (UserModel u : usuarios) {
            if (u.getId().equals(id)) {
                return u;
            }
        }
        return null;
    }
}
