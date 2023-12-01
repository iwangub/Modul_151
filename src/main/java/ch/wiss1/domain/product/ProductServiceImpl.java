package ch.wiss1.domain.product;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductServiceImpl(ProductRepository repository) {

        this.repository = repository;
    }

    @Override
    public Product save(Product entity) {
        // return repository.save(entity);
        return null;
    }

    @Override
    public Product findById(UUID id) {
        // return findOrThrow(repository.findById(id));
        return null;
    }

    @Override
    public List<Product> findAll(Pageable pageable) {
        Page<Product> pagedProducts = repository.findAll(pageable);
        return pagedProducts.hasContent() ? pagedProducts.getContent() : List.of();
    }

    @Override
    public Product updateById(UUID id, Product entity) throws NoSuchElementException {
   /* if (repository.existsById(id)) {
      entity.setId(id);
      return repository.save(entity);
    } else {
      throw new NoSuchElementException(String.format("Product with ID '%s' could not be found", id));
    } */
        return null;
    }

    @Override
    public Void deleteById(UUID id) throws NoSuchElementException {
   /* if (repository.existsById(id)) {
      repository.deleteById(id);
    } else {
      throw new NoSuchElementException(String.format("Product with ID '%s' could not be found", id));
    } */
        return null;
    }

    @Override
    public boolean existsById(UUID id) {
        // return repository.existsById(id);
        return false;
    }

    @Override
    public Product findOrThrow(Optional<Product> optional) throws NoSuchElementException {
        if (optional.isPresent()) {
            return optional.get();
        } else {
            throw new NoSuchElementException("No value present");
        }
    }

    // As soon as we got a database connected to our application, we can fetch the most expensive product from the database
    // and return it. For now, we just return the most expensive product from a list of products!
    @Override
    public Product findMostExpensive() {
        // TODO produkte der DB holen und das teuerste holen 1x mit native und 1xdireve query (findMostExpensive)
        return repository.findFirstProductNativeQuery();

    }


}
