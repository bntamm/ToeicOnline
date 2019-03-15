package vn.tambui.command;

import vn.tambui.core.dto.UserDTO;
import vn.tambui.core.web.command.AbstractCommand;

public class UserCommand extends AbstractCommand<UserDTO> {

public UserCommand(){
    this.pojo = new UserDTO();
}


}
