package fiap.lab.microservices.apiexample.service;

import fiap.lab.microservices.apiexample.model.Sample;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.List;

@Service
public class    SampleService {

    private static List<Sample> REPOSITORY = new ArrayList<>();
    static {
        REPOSITORY.add(new Sample(1, "Exemplo 1"));
        REPOSITORY.add(new Sample(2, "Exemplo 2"));
        REPOSITORY.add(new Sample(3, "Exemplo 3"));
        REPOSITORY.add(new Sample(4, "Exemplo 4"));
        REPOSITORY.add(new Sample(5, "Exemplo 5"));
    }

    public Sample save(Sample sample) {
        REPOSITORY.add(sample);
        return sample;
    }

    public Sample findById(Integer id){
        for (Sample s: REPOSITORY) {
            if (id.equals(s.getId())) {
                return s;
            }
        }
        return null;
    }

    public Iterable<Sample> findAll(){
        return REPOSITORY;
    }
}