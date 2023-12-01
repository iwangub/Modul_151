package ch.wiss1.domain.product.dto;

import ch.wiss1.domain.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ProductMapper {

  Product productDTOToProduct(ProductDTO productDTO);
}
