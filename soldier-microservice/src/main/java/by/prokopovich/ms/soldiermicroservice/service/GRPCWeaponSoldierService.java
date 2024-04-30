package by.prokopovich.ms.soldiermicroservice.service;

import by.prokopovich.ms.soldiermicroservice.repository.SoldierRepository;
import com.example.grpc.GRPCWeapon;
import com.example.grpc.WeaponServerGrpc;
import com.google.protobuf.Empty;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Класс GRPCWeaponSoldierService представляет сервис для обработки GRPC-запросов, связанных с оружием солдат,
 * имплементируя интерфейс WeaponServerGrpc.WeaponServerImplBase.
 */
@GrpcService
public class GRPCWeaponSoldierService  extends WeaponServerGrpc.WeaponServerImplBase {

    private final SoldierRepository repository;

    @Autowired
    public GRPCWeaponSoldierService(SoldierRepository repository) {
        this.repository = repository;
    }
    /**
     * Метод addWeapon обрабатывает GRPC-запрос на добавление оружия к солдату.
     *
     * @param request          GRPCWeapon объект, содержащий информацию о добавляемом оружии.
     * @param responseObserver StreamObserver для отправки ответа на GRPC-запрос.
     */
    @Override
    public void addWeapon(GRPCWeapon request, StreamObserver<Empty> responseObserver) {
        repository.setWeapon(request.getWeaponNumber(),request.getOwnerId());
        responseObserver.onNext(Empty.newBuilder().build());
        responseObserver.onCompleted();
    }
}
