package by.prokopovich.ms.weaponmicroservice.service;


import com.example.grpc.WeaponServerGrpc;
import lombok.RequiredArgsConstructor;
import net.devh.boot.grpc.client.inject.GrpcClient;
import org.springframework.stereotype.Service;
/**
 * Класс GRPCWeaponServiceImpl gRPC-клиентом, реализуя интерфейс GRPCWeaponService
 * и предоставляет методы для отправки gRPC-сообщений на gRPC-сервер
 */
@Service
@RequiredArgsConstructor
public class GRPCWeaponServiceImpl implements GRPCWeaponService {

    @GrpcClient(value = "serial-number-generator-blocking")
    private WeaponServerGrpc.WeaponServerBlockingStub weaponServerBlockingStub;
    /**
     * Метод send отправляет GRPC-сообщение с идентификатором солдата и серийным номером оружия в
     * soldier-microservice/src/main/java/by/prokopovich/ms/soldiermicroservice/service/GRPCWeaponSoldierService.java
     *
     * @param soldierId     Идентификатор солдата
     * @param serialNumber  Серийный номер оружия
     */
    @Override
    public void send(Long soldierId,String serialNumber) {
        com.example.grpc.GRPCWeapon request = com.example.grpc.GRPCWeapon.newBuilder().setOwnerId(soldierId).setWeaponNumber(serialNumber).build();
        weaponServerBlockingStub.addWeapon(request);

    }

}
