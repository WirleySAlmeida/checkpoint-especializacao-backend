package dh.backend.checkpoint.catalogservice.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
public class CatalogDTO implements Serializable {

    private String genre;
}
