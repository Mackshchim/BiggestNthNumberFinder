package tatar.mackshchim.ftbn.findthebiggestnincolumn.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import tatar.mackshchim.ftbn.findthebiggestnincolumn.controllers.api.FindTheBiggestNInColumnAPI;
import tatar.mackshchim.ftbn.findthebiggestnincolumn.services.FindTheBiggestNInColumnService;

@RestController
@RequiredArgsConstructor
public class FindTheBiggestNInColumnController implements FindTheBiggestNInColumnAPI {

    private final FindTheBiggestNInColumnService service;
    @Override
    public ResponseEntity<Double> findTheBiggestNInColumnOfTheFile(String xlsxFilepath, int N) {
        return ResponseEntity.ok(service.findTheBiggestNInColumnOfTheFile(xlsxFilepath, N));
    }
}
