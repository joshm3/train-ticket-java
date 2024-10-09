package modules.tsrebookservice.rebook.service;
import modules.tscommon.edu.fudan.common.util.Response;
import modules.tsrebookservice.rebook.entity.RebookInfo;
import org.springframework.http.HttpHeaders;
/**
 *
 * @author fdse
 */
public interface RebookService {
    Response rebook(RebookInfo info, HttpHeaders headers);

    Response payDifference(RebookInfo info, HttpHeaders headers);
}