package main.com.novaskill.service;
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public void register(RegisterRequest request) {

        if(userRepository.existsByEmail(request.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        User user = User.builder()
                .fullName(request.getFullName())
                .email(request.getEmail())
                .password(
                    passwordEncoder.encode(
                        request.getPassword()
                    )
                )
                .role(Role.STUDENT)
                .balance(0.0)
                .isActive(true)
                .build();

        userRepository.save(user);
    }
}