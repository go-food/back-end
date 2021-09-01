package gofood;

import gofood.account.Account;
import gofood.account.AccountRepository;
import gofood.product.ProductRepository;
import gofood.productCategory.ProductCategory;
import gofood.productCategory.ProductCategoryRepository;
import gofood.restaurant.Restaurant;
import gofood.restaurant.RestaurantRepository;
import org.apache.tomcat.jni.Library;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class dummydata {
    @Bean
    CommandLineRunner commandLineRunner2(AccountRepository accountRepo,
                                         RestaurantRepository restaurantRepo,
                                         ProductCategoryRepository categoryRepo,
                                         ProductRepository productRepo) {
        return args -> {
            //Load customer
            Account acc1 = new Account("Augustus","ameriott0@vimeo.com","k2UEV8","960 276 0874","174 Nelson Circle",38.9);
            Account acc2 = new Account("Emery","epankettman1@altervista.org","J44tGk","257 898 8000","500 Mendota Point",54.2);
            Account acc3 = new Account("Monika","mwinspear2@nydailynews.com","SMP9rvUsw","790 637 1294","09947 Kensington Pass",35.4);

            accountRepo.saveAll(List.of(acc1, acc2, acc3));
            Restaurant res1 = new Restaurant("56 Westport Road","Burk","duis mattis egestas metus aenean fermentum donec ut mauris","3:54","11:11",false           );
            Restaurant res2 = new Restaurant("9376 Myrtle Park","Gerardo","nec nisi vulputate nonummy maecenas tincidunt lacus at velit vivamus vel nulla eget","2:23","6:02",true);
            Restaurant res3 = new Restaurant("931 Hollow Ridge Pass","Thorndike","nunc vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere","4:44","2:56",false);

            restaurantRepo.saveAll(List.of(res1, res2, res3));


        };
    }
}