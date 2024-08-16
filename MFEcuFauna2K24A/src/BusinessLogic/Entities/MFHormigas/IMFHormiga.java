package BusinessLogic.Entities.MFHormigas;

import BusinessLogic.Entities.MFAlimento.MFCarnivoro;
import BusinessLogic.Entities.MFAlimento.MFHervivoro;
import BusinessLogic.Entities.MFAlimento.MFInsectivoro;
import BusinessLogic.Entities.MFAlimento.MFNectarivoros;
import BusinessLogic.Entities.MFAlimento.MFOmnivoro;

public interface IMFHormiga {
    public boolean comer (MFCarnivoro mfCarnivoro);

    public boolean comer (MFHervivoro mfHervivoro);

    public boolean comer (MFOmnivoro mfOmnivoro);

    public boolean comer (MFInsectivoro mfInsectivoro);

    public boolean comer (MFNectarivoros mfnNectarivoros);
}
