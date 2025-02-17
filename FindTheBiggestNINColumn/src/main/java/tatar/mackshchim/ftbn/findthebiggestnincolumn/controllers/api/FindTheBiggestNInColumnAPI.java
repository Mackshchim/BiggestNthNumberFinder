package tatar.mackshchim.ftbn.findthebiggestnincolumn.controllers.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import tatar.mackshchim.ftbn.findthebiggestnincolumn.dto.ExceptionDto;

@Tags(value = {
        @Tag(name = "Biggest Nth number")
})
@RequestMapping("/")
public interface FindTheBiggestNInColumnAPI {


    @Operation(summary = "Finding Nth biggest number of XLSX file column")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Current User ID, Interlocutor ID, messages",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = Double.class))
                    }),
            @ApiResponse(responseCode = "404", description = "Exception info",
                    content = {
                            @Content(mediaType = "application/json", schema = @Schema(implementation = ExceptionDto.class))
                    })
    })
    @GetMapping()
    public ResponseEntity<Double> findTheBiggestNInColumnOfTheFile(
            @Parameter(description = "Absolute filepath of XLSX formatted file")
            @RequestParam("xlsx-filepath")String xlsxFilepath,
            @Parameter(description = "The serial number of desired biggest number(N)")
            @RequestParam("n")int N);

}
