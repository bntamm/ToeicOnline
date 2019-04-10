package vn.tambui.command;

import vn.tambui.core.dto.ListenGuidelineDTO;
import vn.tambui.core.web.command.AbstractCommand;

public class ListenGuidelineCommand extends AbstractCommand<ListenGuidelineDTO> {

    public ListenGuidelineCommand() {
        this.pojo = new ListenGuidelineDTO();
    }
}
