package by.prokopovich.ms.weaponmicroservice.service;


import com.example.grpc.WeaponServerGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GRPCWeaponServiceImpl implements GRPCWeaponService {

    @GrpcClient(value = "serial-number-generator-blocking")
    private WeaponServerGrpc.WeaponServerBlockingStub weaponServerBlockingStub;

    @Override
    public void send(Long soldierId,String serialNumber) {
        com.example.grpc.GRPCWeapon request = com.example.grpc.GRPCWeapon.newBuilder().setOwnerId(soldierId).setWeaponNumber(serialNumber).build();
        weaponServerBlockingStub.addWeapon(request);

    }

}
