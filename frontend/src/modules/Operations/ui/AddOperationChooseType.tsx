import { Typography } from "@material-tailwind/react";
import BackLink from "@/ui/BackLink.tsx";
import { IncomeType } from "@/modules/Operations/types/income.ts";
import { ExpenseType } from "@/modules/Operations/types/expense.ts";
import { useParams } from "react-router-dom";
import ChooseOperationItem from "@/modules/Operations/ui/ChooseOperationItem.tsx";
import { useTypedTranslation } from "@/helpers/useTypedTranslation.ts";

const AddOperationChooseType = () => {
  const { kind, periodic } = useParams<{
    kind: "expenses" | "incomes";
    periodic: "periodic" | "oneTime";
  }>();
  const { t } = useTypedTranslation();
  const incomes: IncomeType[] = [
    "SALARY",
    "GIFTS",
    "INVESTMENT",
    "PASSIVE",
    "PART-TIME-JOB",
  ];
  const expenses: ExpenseType[] = [
    "FOOD",
    "TRANSPORT",
    "ENTERTAINMENTS",
    "HEALTH",
    "PERSONAL",
    "HOUSE",
    "EDUCATION",
  ];
  const list = kind === "expenses" ? expenses : incomes;
  return (
    <div className="flex flex-col gap-6">
      <BackLink to={`/addOperation/${periodic}`} />
      <Typography variant="h4" className="font-semibold">
        {t("which-operation-type-you-want-to-add")}
      </Typography>
      <div>
        {kind &&
          periodic &&
          list.map((el) => (
            <ChooseOperationItem
              periodic={periodic}
              type={el}
              key={el}
              kind={kind}
            />
          ))}
      </div>
    </div>
  );
};

export default AddOperationChooseType;
