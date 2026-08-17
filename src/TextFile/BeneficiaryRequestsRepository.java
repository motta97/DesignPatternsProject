package TextFile;

import BeneficaryManagement.Beneficiary;
import BeneficaryManagement.DigitalTransfer;
import BeneficaryManagement.HomeDelivery;
import BeneficaryRequestStatus.*;

import java.util.ArrayList;
import java.util.List;

public class BeneficiaryRequestsRepository {
    private final  String filePath = "data/BeneficiaryRequests.txt" ;
    private TextFileHandler texthandler ;
    public BeneficiaryRequestsRepository(){
        texthandler = TextFileHandler.GetInstance() ;
    }

    public List<BeneficiaryRequest> getAll(){
        List<BeneficiaryRequest> Requests = new ArrayList<>();
        List<String> Lines = texthandler.ReadFile(filePath);
        for(String line : Lines){
            if(line.startsWith("#")){
                continue;
            }
           try{

               String[] parts = line.split("\\|" ,-1) ;
               int requestId = Integer.parseInt(parts[0]) ;
               String state =  parts[1] ;
               RequestState Requeststate = new NewState() ;
               switch (state){
                   case "New" -> Requeststate = new NewState() ;
                   case "Pending" -> Requeststate = new PendingState() ;
                   case "Rejected" -> Requeststate = new RejectedState() ;
                   case "InProgress" -> Requeststate = new InProgressState() ;
                   case "Completed" -> Requeststate = new CompletedState() ;
                   case "Approved" -> Requeststate = new ApprovedState() ;

               }

               String Request = parts[2] ;

               int beneficaryId = Integer.parseInt(parts[3]) ;

               BeneficiaryRequest beneficiaryRequest = new BeneficiaryRequest(beneficaryId , Request) ;
               beneficiaryRequest.SetState(Requeststate);
               beneficiaryRequest.setRequestId(requestId);
               Requests.add(beneficiaryRequest) ;
           }catch (Exception e){
               System.out.println(e.getMessage());
           }

        }

        return Requests ;


    }


    public void SaveAll(List<BeneficiaryRequest> Requests){
        List<String> lines = new ArrayList<>();

        lines.add("#requestId|state|request|beneficaryId");
        for (BeneficiaryRequest request : Requests) {
            String line = request.getRequestId()+"|"+request.getState()+"|"+request.getRequest()+"|"+request.getBeneficiaryId();
            lines.add(line) ;
        }
        texthandler.WriteLine(filePath,lines);

    }

}
