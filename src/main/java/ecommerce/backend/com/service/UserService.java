package ecommerce.backend.com.service;

import ecommerce.backend.com.model.User;
import org.springframework.data.domain.Page;

import java.util.Optional;

/**
 * @author Huy Thắng on 26/06/2020
 * @project ecommerce_backend
 */
public interface UserService {

    /**
     * Tìm User theo Email và Password
     *
     * @param email    String email cần tìm kiếm
     * @param password String mật khẩu tìm kiếm
     * @return User
     */
    User findUserByEmailAndPassword(String email, String password);

    /**
     * Tìm user theo Email
     *
     * @param email String email tìm kiếm
     * @return User
     */
    User findByEmail(String email);

    /**
     * Tìm User theo Id
     *
     * @param id Long Id user
     * @return Optional<User>
     */
    Optional<User> findById(Long id);

    /**
     * Tìm danh sách User phân trang
     *
     * @param page Integer Trang cần tìm
     * @param size Integer Số lượng user trong một trang
     * @return Page<User>
     */
    Page<User> findAllUser(Integer page, Integer size);

    /**
     * Tìm danh sách User phân trang theo từ khóa
     *
     * @param search String từ khóa tìm kiếm
     * @param page   Integer Trang cần tìm
     * @param size   Integer Số lượng user trong một trang
     * @return Page<User>
     */
    Page<User> findAllUserByEmail(String search, Integer page, Integer size);

    /**
     * Thêm mới/Cập nhật User
     *
     * @param user User Thông tin user
     * @return User
     */
    User save(User user);

    /**
     * Xóa người dùng theo ID
     *
     * @param id Long ID User cần xóa
     * @return true - nếu xóa thành công /false - nếu xóa không thành công
     */
    boolean deleteUserById(Long id);
}
