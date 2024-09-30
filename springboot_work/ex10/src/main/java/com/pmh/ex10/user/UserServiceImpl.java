package com.pmh.ex10.user;

import com.pmh.ex10.error.BizException;
import com.pmh.ex10.error.ErrorCode;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    public void insert(UserReqDto userReqDto){

        Optional<User> optionalUser = userRepository.findByEmail(userReqDto.getEmail());
        optionalUser.ifPresent(user -> {
            throw new BizException(ErrorCode.DUPLICATE_USERS);
        });

        System.out.println("실행"+ userReqDto);
        ModelMapper modelMapper = new ModelMapper();
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = "+ user);
        userRepository.save(user);

    }

    @Override
    public void update(UserReqDto userReqDto) {
        User user = modelMapper.map(userReqDto, User.class);
        System.out.println("user = "+ user);

        User dbUser = userRepository.findById(
                user.getIdx()).orElseThrow(() -> { throw new BizException(ErrorCode.NOT_FOUND); } );

        user.setWdate(dbUser.getWdate());
//        user.setEmail(dbUser.getEmail());
//        user.setPassword(dbUser.getPassword());

        userRepository.save(user);
    }
}
