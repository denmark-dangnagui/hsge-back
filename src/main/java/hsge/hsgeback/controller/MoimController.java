package hsge.hsgeback.controller;

import hsge.hsgeback.dto.MoimDto;
import hsge.hsgeback.entity.Moim;
import hsge.hsgeback.repository.MoimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/moims")
public class MoimController {

    private final MoimRepository moimRepository;

    @GetMapping
    public List<Moim> getAllMoim(){
        List<Moim> all = moimRepository.findAll();
        return all;
    }

    @GetMapping("/{moimId}")
    public Moim getOneMoim(@PathVariable Long moimId){
        Optional<Moim> optional = moimRepository.findById(moimId);
        if (optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        Moim moim = optional.get();
        Moim dto = Moim.builder()
                .title(moim.getTitle())
                .people(moim.getPeople())
                .location(moim.getLocation())
                .content(moim.getContent())
                .build();
        return dto;
    }

    @DeleteMapping("/{moimId}")
    public void deleteMoim(@PathVariable Long moimId){
        moimRepository.deleteById(moimId);
    }

    @PutMapping("/{moimId}")
    public void putMoim(@PathVariable Long moimId, Moim moim){
        Optional<Moim> optional = moimRepository.findById(moimId);
        if (optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        Moim putMoim = optional.get();
        putMoim.setLocation(moim.getLocation());
        putMoim.setTitle(moim.getTitle());
        putMoim.setContent(moim.getContent());
        putMoim.setPeople(moim.getPeople());
    }

    @PostMapping
    public void postMoim(@RequestBody MoimDto moim){
        Moim savedMoim = Moim.builder()
                .title(moim.getTitle())
                .content(moim.getContent())
                .location(moim.getLocation())
                .people(moim.getPeople())
                .build();
        moimRepository.save(savedMoim);
    }

}
