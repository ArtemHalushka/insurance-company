package insurances;

import company.InsuranceCompany;

public interface IRequest {

    InsuranceRequest requestInsurance(InsuranceCompany company, Object insureObject);
}
