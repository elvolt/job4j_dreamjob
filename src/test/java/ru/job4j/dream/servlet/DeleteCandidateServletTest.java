package ru.job4j.dream.servlet;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import ru.job4j.dream.model.Candidate;
import ru.job4j.dream.store.MemStore;
import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.Store;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotEquals;
import static org.mockito.Mockito.mock;

@RunWith(PowerMockRunner.class)
@PrepareForTest(PsqlStore.class)
public class DeleteCandidateServletTest {
    @Test
    public void whenDeleteCandidate() throws IOException {
        Store store = MemStore.instOf();
        PowerMockito.mockStatic(PsqlStore.class);
        PowerMockito.when(PsqlStore.instOf()).thenReturn(store);
        HttpServletRequest req = mock(HttpServletRequest.class);
        HttpServletResponse resp = mock(HttpServletResponse.class);
        store.save(new Candidate(0, "User"));
        List<Candidate> candidates = new ArrayList<>(store.findAllCandidates());
        Candidate lastCandidate = candidates.get(candidates.size() - 1);
        PowerMockito.when(req.getParameter("id"))
                .thenReturn(String.valueOf(lastCandidate.getId()));
        new DeleteCandidateServlet().doPost(req, resp);
        assertNotEquals(candidates.size(), store.findAllCandidates().size());
    }
}