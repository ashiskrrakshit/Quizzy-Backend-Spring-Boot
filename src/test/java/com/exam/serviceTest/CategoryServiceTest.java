package com.exam.serviceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.exam.model.exam.Category;
import com.exam.repo.CategoryRepository;
import com.exam.service.impl.CategoryServiceImpl;

public class CategoryServiceTest {

    @Mock
    private CategoryRepository categoryRepository;

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @BeforeEach
    public void init() {
    	MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAddCategory() {
        Category category = new Category("Test Category", "Test Description");
        when(categoryRepository.save(category)).thenReturn(category);

        Category savedCategory = categoryService.addCategory(category);

        assertEquals("Test Category", savedCategory.getTitle());
        assertEquals("Test Description", savedCategory.getDescription());
    }

    @Test
    public void testUpdateCategory() {
        Category category = new Category("Test Category", "Test Description");
        when(categoryRepository.save(category)).thenReturn(category);

        Category updatedCategory = categoryService.updateCategory(category);

        assertEquals("Test Category", updatedCategory.getTitle());
        assertEquals("Test Description", updatedCategory.getDescription());
    }

    @Test
    public void testGetCategories() {
        List<Category> categories = new LinkedList<>();
        categories.add(new Category("Category 1", "Description 1"));
        categories.add(new Category("Category 2", "Description 2"));

        when(categoryRepository.findAll()).thenReturn(categories);

        Set<Category> retrievedCategories = categoryService.getCategories();

        assertEquals(2, retrievedCategories.size());
    }

    @Test
    public void testGetCategory() {
        Category category = new Category("Test Category", "Test Description");
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));

        Category retrievedCategory = categoryService.getCategory(1L);

        assertEquals("Test Category", retrievedCategory.getTitle());
        assertEquals("Test Description", retrievedCategory.getDescription());
    }

    @Test
    public void testDeleteCategory() {
        doNothing().when(categoryRepository).delete(any(Category.class));

        categoryService.deleteCategory(1L);

        verify(categoryRepository, times(1)).delete(any(Category.class));
    }
}
