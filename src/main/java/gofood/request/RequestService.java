package gofood.request;

import gofood.base.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class RequestService extends BaseService<Request> {

    @Autowired
    protected RequestService(RequestRepository repo) {
        super(repo);
    }

    @Override
    public Request updateById(Request updatedRequest, Integer id) {
        Request request = repo.findById(id).get();
        if (updatedRequest.getContent() != null) request.setContent(updatedRequest.getContent());
        if (updatedRequest.getStatus() != null) request.setStatus(updatedRequest.getStatus());
        return request;
    }
}
